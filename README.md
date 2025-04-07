# 🌿 FloruitClearLag

O **FloruitClearLag** é um plugin leve e personalizável para servidores Minecraft que remove itens do chão periodicamente, ajudando a manter o desempenho do servidor sem comprometer a jogabilidade.

## 📦 Funcionalidades

- Limpeza automática de itens do chão em intervalos configuráveis.
- Mensagens de aviso antes da limpeza com tempos personalizáveis.
- Feedback ao jogador após a limpeza.
- Mensagem personalizada caso nenhum item seja encontrado.

## ⚙️ Configuração

As configurações são feitas no `config.yml` do plugin. Abaixo estão as chaves disponíveis:

```yaml
clear-interval-seconds: 600 # Intervalo entre limpezas em segundos (padrão: 600s = 10 minutos)

warning-times-seconds:      # Lista de tempos (em segundos) para avisos antes da limpeza
  - 60
  - 30
  - 10

messages:
  warning: "§e[ClearLag] Items will be removed in {seconds} seconds!"
  clear: "§a[ClearLag] {amount} items were removed!"
  no-items: "§a[ClearLag] No items were found to remove!"
```

## 🔁 Conversão de Tempo

Todos os valores de tempo em segundos são automaticamente convertidos para ticks pelo plugin (1 segundo = 20 ticks).

## 📂 Estrutura Interna

| Chave                 | Descrição |
|----------------------|-----------|
| `clearIntervalTicks` | Tempo total entre as limpezas em ticks |
| `warningTimesTicks`  | Lista de tempos de aviso em ticks |
| `warningMessage`     | Mensagem exibida antes da limpeza |
| `clearMessage`       | Mensagem exibida após limpar os itens |
| `noItemsMessage`     | Mensagem exibida se não houver itens para limpar |

## ✅ Dependências

- Nenhuma dependência externa necessária.

## 🛠️ Instalação

1. Adicione o `.jar` do plugin na pasta `plugins/` do seu servidor.
2. Reinicie o servidor ou use `/reload`.
3. Edite o `config.yml` conforme desejado.

---
