# 🌿 FloruitClearLag

O **FloruitClearLag** é um plugin leve e altamente personalizável para servidores Minecraft, projetado para remover itens do chão periodicamente, contribuindo significativamente para a performance do servidor sem afetar negativamente a jogabilidade dos jogadores.

## 📦 Funcionalidades

* 🧹 **Limpeza automática** de itens do chão em intervalos configuráveis.
* ⏰ **Avisos programados** antes da limpeza, com múltiplos tempos personalizáveis.
* ✅ **Feedback direto** aos jogadores após a remoção.
* ❌ **Mensagem específica** quando não há itens para serem removidos.

## ⚙️ Configuração

Todas as configurações estão localizadas no arquivo `config.yml`. Exemplo de configuração padrão:

```yaml
clear-interval-seconds: 600 # Tempo entre limpezas automáticas (em segundos)

warning-times-seconds:      # Tempos dos avisos prévios antes da limpeza (em segundos)
  - 60
  - 30
  - 10

messages:
  warning: "§e[ClearLag] Items will be removed in {seconds} seconds!"
  clear: "§a[ClearLag] {amount} items were removed!"
  no-items: "§a[ClearLag] No items were found to remove!"
```

> 🔄 **Observação:** Todos os valores em segundos são automaticamente convertidos para *ticks* (1 segundo = 20 ticks).

## 🧬 Estrutura Interna

| Chave                | Descrição                                        |
| -------------------- | ------------------------------------------------ |
| `clearIntervalTicks` | Tempo entre limpezas convertido em ticks         |
| `warningTimesTicks`  | Lista de tempos de aviso convertidos em ticks    |
| `warningMessage`     | Mensagem exibida antes de cada limpeza           |
| `clearMessage`       | Mensagem exibida após a limpeza de itens         |
| `noItemsMessage`     | Mensagem exibida caso não haja itens para limpar |

## ✅ Dependências

* Nenhuma dependência externa é necessária. O plugin é 100% standalone.

## 🛠️ Instalação

1. Coloque o arquivo `.jar` do plugin na pasta `plugins/` do seu servidor.
2. Reinicie o servidor ou execute `/reload` (não recomendado em produção).
3. Edite o arquivo `config.yml` conforme sua preferência.
4. Pronto! O plugin iniciará automaticamente e executará as limpezas conforme configurado.

---
