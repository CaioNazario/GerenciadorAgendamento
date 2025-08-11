#!/usr/bin/env pwsh

param(
    [Parameter(Mandatory=$true, HelpMessage="Tipo da mudança (feat, fix, docs, style, refactor, test, chore, perf)")]
    [ValidateSet("feat", "fix", "docs", "style", "refactor", "test", "chore", "perf")]
    [string]$Type,
    
    [Parameter(Mandatory=$false, HelpMessage="Escopo da mudança (opcional: api, auth, ui, etc)")]
    [string]$Scope,
    
    [Parameter(Mandatory=$true, HelpMessage="Descrição da mudança")]
    [string]$Description
)

# Constrói a mensagem de commit
$COMMIT_MSG = $Type

# Adiciona o escopo se fornecido
if (-not [string]::IsNullOrEmpty($Scope)) {
    $COMMIT_MSG = "$COMMIT_MSG($Scope)"
}

# Adiciona os dois pontos e a descrição
$COMMIT_MSG = "$COMMIT_MSG: $Description"

Write-Host "🔄 Iniciando processo de commit..." -ForegroundColor Cyan

# Adiciona todos os arquivos modificados
try {
    git add .
    Write-Host "✔️ Arquivos adicionados ao stage." -ForegroundColor Green
} catch {
    Write-Host "❌ Erro ao adicionar arquivos ao stage: $_" -ForegroundColor Red
    exit 1
}

# Executa o commit
try {
    git commit -m $COMMIT_MSG
    Write-Host "🚀 Commitado com sucesso: $COMMIT_MSG" -ForegroundColor Green
} catch {
    Write-Host "❌ Erro ao fazer commit: $_" -ForegroundColor Red
    exit 1
}

# Envia as alterações para o repositório remoto
try {
    git push
    Write-Host "✅ Push realizado! Seu trabalho está a salvo nas nuvens." -ForegroundColor Green
} catch {
    Write-Host "❌ Erro ao fazer push: $_" -ForegroundColor Red
    exit 1
}

Write-Host "🎉 Processo concluído com sucesso!" -ForegroundColor Magenta
