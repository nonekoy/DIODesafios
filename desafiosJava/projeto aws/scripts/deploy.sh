#!/bin/bash

echo "🚀 Iniciando deploy na AWS..."

# Configurações
APP_NAME="projeto-portfolio"
REGION="us-east-1"
INSTANCE_TYPE="t2.micro"
KEY_NAME="sua-key-pair"

echo "📋 Verificando pré-requisitos..."

# Verificar se AWS CLI está instalado
if ! command -v aws &> /dev/null; then
    echo "❌ AWS CLI não encontrado. Instale primeiro:"
    echo "   https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2.html"
    exit 1
fi

# Verificar se as credenciais estão configuradas
if ! aws sts get-caller-identity &> /dev/null; then
    echo "❌ Credenciais AWS não configuradas. Execute:"
    echo "   aws configure"
    exit 1
fi

echo "✅ Pré-requisitos verificados!"

# Criar bucket S3 para arquivos estáticos
echo "🪣 Criando bucket S3..."
BUCKET_NAME="${APP_NAME}-static-$(date +%s)"
aws s3 mb s3://$BUCKET_NAME --region $REGION

# Configurar bucket para website estático
aws s3 website s3://$BUCKET_NAME --index-document index.html --error-document error.html

# Fazer upload dos arquivos estáticos
echo "📤 Fazendo upload dos arquivos..."
aws s3 sync frontend/ s3://$BUCKET_NAME --delete

# Criar instância EC2
echo "🖥️ Criando instância EC2..."
INSTANCE_ID=$(aws ec2 run-instances \
    --image-id ami-0c55b159cbfafe1f0 \
    --count 1 \
    --instance-type $INSTANCE_TYPE \
    --key-name $KEY_NAME \
    --security-group-ids sg-0123456789abcdef0 \
    --subnet-id subnet-0123456789abcdef0 \
    --user-data "#!/bin/bash
        yum update -y
        yum install -y nodejs npm git
        git clone https://github.com/seu-usuario/$APP_NAME.git
        cd $APP_NAME
        npm install
        npm start" \
    --query 'Instances[0].InstanceId' \
    --output text \
    --region $REGION)

echo "⏳ Aguardando instância ficar disponível..."
aws ec2 wait instance-running --instance-ids $INSTANCE_ID --region $REGION

# Obter IP público
PUBLIC_IP=$(aws ec2 describe-instances \
    --instance-ids $INSTANCE_ID \
    --query 'Reservations[0].Instances[0].PublicIpAddress' \
    --output text \
    --region $REGION)

echo "✅ Deploy concluído!"
echo "🌐 Aplicação disponível em: http://$PUBLIC_IP:3000"
echo "🪣 Arquivos estáticos em: http://$BUCKET_NAME.s3-website-$REGION.amazonaws.com"
echo "🖥️ ID da instância: $INSTANCE_ID"

# Salvar informações do deploy
echo "📝 Salvando informações do deploy..."
cat > deploy-info.txt << EOF
Deploy realizado em: $(date)
Aplicação: $APP_NAME
Instância EC2: $INSTANCE_ID
IP Público: $PUBLIC_IP
Bucket S3: $BUCKET_NAME
URL da aplicação: http://$PUBLIC_IP:3000
URL dos arquivos estáticos: http://$BUCKET_NAME.s3-website-$REGION.amazonaws.com
EOF

echo "📁 Informações salvas em deploy-info.txt"
echo "🎉 Deploy finalizado com sucesso!"
