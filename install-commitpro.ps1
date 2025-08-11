# Script para instalar a função commitpro no perfil do PowerShell

$FunctionContent = @"
function commitpro {
    param(
        [Parameter(Mandatory=`$true, Position=0)]
        [ValidateSet("feat", "fix", "docs", "style", "refactor", "test", "chore", "perf")]
        [string]`$Type,
        
        [Parameter(Mandatory=`$false, Position=1)]
        [string]`$Scope,
        
        [Parameter(Mandatory=`$true, Position=2)]
        [string]`$Description
    )
    
    # Constrói a mensagem de commit
    `$COMMIT_MSG = `$Type
    
    # Adiciona o escopo se fornecido
    if (-not [string]::IsNullOrEmpty(`$Scope)) {
        `$COMMIT_MSG = "`$COMMIT_MSG(`$Scope)"
    }
    
    # Adiciona os dois pontos e a descrição
    `$COMMIT_MSG = "`$COMMIT_MSG: `$Description"
    
    Write-Host "🔄 Iniciando processo de commit..." -ForegroundColor Cyan
    
    # Adiciona todos os arquivos modificados
    try {
        git add .
        Write-Host "✔️ Arquivos adicionados ao stage." -ForegroundColor Green
    } catch {
        Write-Host "❌ Erro ao adicionar arquivos ao stage: `$_" -ForegroundColor Red
        return
    }
    
    # Executa o commit
    try {
        git commit -m `$COMMIT_MSG
        Write-Host "🚀 Commitado com sucesso: `$COMMIT_MSG" -ForegroundColor Green
    } catch {
        Write-Host "❌ Erro ao fazer commit: `$_" -ForegroundColor Red
        return
    }
    
    # Envia as alterações para o repositório remoto
    try {
        git push
        Write-Host "✅ Push realizado! Seu trabalho está a salvo nas nuvens." -ForegroundColor Green
    } catch {
        Write-Host "❌ Erro ao fazer push: `$_" -ForegroundColor Red
        return
    }
    
    Write-Host "🎉 Processo concluído com sucesso!" -ForegroundColor Magenta
}
"@

# Verifica se o perfil existe, se não, cria
if (!(Test-Path $PROFILE)) {
    New-Item -ItemType File -Path $PROFILE -Force
    Write-Host "✅ Perfil PowerShell criado em: $PROFILE" -ForegroundColor Green
}

# Adiciona a função ao perfil
Add-Content -Path $PROFILE -Value "`n# commitpro function`n$FunctionContent`n"

Write-Host "✅ Função commitpro adicionada ao perfil PowerShell!" -ForegroundColor Green
Write-Host "🔄 Reinicie o PowerShell ou execute '. `$PROFILE' para carregar a função." -ForegroundColor Yellow
Write-Host ""
Write-Host "Como usar:" -ForegroundColor Cyan
Write-Host "  commitpro feat 'adiciona nova funcionalidade'" -ForegroundColor White
Write-Host "  commitpro fix auth 'corrige bug no login'" -ForegroundColor White
Write-Host "  commitpro docs 'atualiza README'" -ForegroundColor White
