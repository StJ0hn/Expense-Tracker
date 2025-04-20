### **Expense Tracker - Roadmap.sh**
Esse é um projeto para você aplicar seus conhecimentos e desenvolver um "Expense Tracker" (rastreador de despesas), que é uma aplicação que ajuda a monitorar, registrar e organizar seus gastos.
#### **Habilidades necessárias**
Você vai precisar de conhecimentos nas seguintes áreas para desenvolver este projeto:
1. **Estruturas de Dados**: Como o uso de listas e dicionários (Map) para armazenar as despesas.
2. **Manipulação de Arquivos**: Como salvar e ler informações de arquivos CSV para armazenar as despesas.    
3. **Lógica de Programação**: Para implementar funções que permitem adicionar, remover, listar e resumir as despesas.
4. **Interface de Linha de Comando (CLI)**: Para criar uma interação simples via terminal.
---

#### **Requisitos do Projeto**

1. **Adicionar Despesa**: Você precisa criar uma funcionalidade para adicionar uma nova despesa. Ela deve incluir informações como descrição, valor e data.
    
2. **Listar Despesas**: Uma funcionalidade que mostre todas as despesas registradas.
    
3. **Excluir Despesa**: Deve ser possível remover uma despesa.
    
4. **Resumo de Despesas**: Criar uma funcionalidade que calcule o total gasto.
    
5. **Resumo de Despesas por Mês**: Mostrar o total gasto em um mês específico.
    

---

#### **Funcionalidades Detalhadas**

1. **Comando "add"**: Para adicionar uma nova despesa.
    
    - Exemplo: `add --description "Almoço" --amount 20`
        
2. **Comando "list"**: Para listar todas as despesas registradas.
    
    - Exemplo: `list`
        
3. **Comando "delete"**: Para excluir uma despesa com base no ID.
    
    - Exemplo: `delete --id 123`
        
4. **Comando "summary"**: Para mostrar o total gasto.
    
    - Exemplo: `summary`
        
5. **Comando "summary --month <número>"**: Para mostrar o total gasto no mês específico.
    
    - Exemplo: `summary --month 3` (onde 3 é o mês de março)
        

---

### **Ferramentas recomendadas**

- **Picocli** (para CLI)
    
- **OpenCSV** (para manipulação de arquivos CSV)