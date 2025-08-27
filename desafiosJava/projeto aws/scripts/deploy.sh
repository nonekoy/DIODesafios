#!/bin/bash

echo "🏥 Deploy do Sistema Farmacêutico na AWS"
echo "=========================================="

# Verificar AWS CLI
if ! command -v aws &> /dev/null; then
    echo "❌ AWS CLI não encontrado"
    echo "📥 Instale em: https://aws.amazon.com/cli/"
    exit 1
fi

echo "✅ AWS CLI encontrado"

# Configurações básicas
REGION="us-east-1"
APP_NAME="farmacia-aws"

echo ""
echo "🚀 Iniciando deploy..."

# 1. Criar bucket S3 para frontend
echo "📦 Criando bucket S3..."
BUCKET_NAME="${APP_NAME}-frontend-$(date +%s)"
aws s3 mb s3://$BUCKET_NAME --region $REGION

# 2. Configurar bucket como website
aws s3 website s3://$BUCKET_NAME --index-document index.html

# 3. Fazer upload dos arquivos
echo "📤 Fazendo upload dos arquivos..."
aws s3 sync frontend/ s3://$BUCKET_NAME

# 4. Criar instância EC2 básica
echo "🖥️ Criando instância EC2..."
INSTANCE_ID=$(aws ec2 run-instances \
    --image-id ami-0c55b159cbfafe1f0 \
    --count 1 \
    --instance-type t2.micro \
    --key-name default \
    --security-group-ids default \
    --user-data "#!/bin/bash
        yum update -y
        yum install -y nodejs npm git
        git clone https://github.com/venelouis/farmacia-aws.git
        cd farmacia-aws
        npm install
        npm start" \
    --query 'Instances[0].InstanceId' \
    --output text \
    --region $REGION)

echo "⏳ Aguardando instância ficar disponível..."
aws ec2 wait instance-running --instance-ids $INSTANCE_ID --region $REGION

# 5. Obter IP público
PUBLIC_IP=$(aws ec2 describe-instances \
    --instance-ids $INSTANCE_ID \
    --query 'Reservations[0].Instances[0].PublicIpAddress' \
    --output text \
    --region $REGION)

echo ""
echo "🎉 Deploy concluído!"
echo "===================="
echo "🌐 Frontend: http://$BUCKET_NAME.s3-website-$REGION.amazonaws.com"
echo "🔗 Backend: http://$PUBLIC_IP:3000"
echo "🖥️ Instância: $INSTANCE_ID"
echo "📁 Bucket: $BUCKET_NAME"

# Salvar informações
echo "📝 Salvando informações..."
cat > deploy-info.txt << EOF
Deploy: $(date)
Frontend: http://$BUCKET_NAME.s3-website-$REGION.amazonaws.com
Backend: http://$PUBLIC_IP:3000
Instância: $INSTANCE_ID
Bucket: $BUCKET_NAME
EOF

echo "✅ Informações salvas em deploy-info.txt"
