### TCC Spring System

___

The system consists in a application which provides to the user the possibility to execute the following functionalities:

___

1 - Access the application through login access page.
___




TASKS TO BE DONE

1 - HomePage {


	- Menu com todos itens necessários ->
	 (Relatórios (n/p) / Administração de Valores, Banco de Sabores, Usuários);

	- Painel com Pedidos do dia -> (Total / Realizados / Em produção / Com problema);

	- Lista de Pedidos em Produção com Links ->
	  (Nome do cliente, telefone, horario do pedido, endereço
	   = Confirmar Pagamento [[ Confirma o pedido como pago, altera o status e remove da lista da homepage]] 
	   = Editar Pedido [[ Abre a página editar-pedido]]
	   = Reimprimir Pedido [[ Reimprime ele automaticamente (confirmation msg) ]]
	   = Excluir Pedido [[ confirmation msg before exec]]

	- Botão Adicionar novo Pedido [[ Abre a página de adicionar novo pedido]];		


}

2 - Relatórios Normais page{
	
	Poderá ser filtrado por dia ou mes

	- Código, nome cliente, endereço, hora do pedido, confirmação do pedido, pedido, valor total pedido

	resultados:
	- numero total de pedidos
	- valor total de todos pedidos
	- Periodo da filtragem

	botao voltar
}

3 - Relatórios de problema page{
	
	Poderá ser filtrado por dia ou mes

	- Código, nome cliente, endereço, hora do pedido, confirmação do pedido, pedido, valor total pedido

	resultados:
	- numero total de pedidos
	- valor total de todos pedidos
	- Periodo da filtragem

	botao voltar
}

4 - Administração de Valores page {

	terei que ver
}

5 - Banco de Sabores page {
	
	lista de sabores - id, nome, especial (bool), [ botao excluir]
	Botão adicionar
	botao de voltar
}

6 - Usuários page {
	
	lista de usuarios - id, nome, roles,  [editar / excluir]
	botao adicionar
	botao voltar

}

7 - Adicionar novo pedido page {

	lista de itens já adicionados / pode estar vazia - valor de cada item / [editar /excluir]
	botao adicionar novo item, que pode ser PIZZA ou BEBIDA

	forma de pagamento (cartao ou dinheiro)
	se for cartao pergunta bandeira
	se for dinheiro pergunta troco para quanto

	deve ser mostrada a quantidade de itens e valor total do pedido
	botao fechar pedido [ao clicar deve setar o pedido em produção e já imprimir o mesmo]
	botao cancelar e voltar
}

8 - Adicionar Item pizza page {
	
	Vai ser solicitado os seguintes campos:
	Nome do cliente
	telefone
	endereco
	tamanho da pizza

	se for grande ou gigante (se vai ter borda ou nao)
	sabores (broto 1 / media ate 2 / grande ate 3 / gigante ate 4)

	se tiver sabores especial, o valor devera ser recalculado e ajustado

	botao adicionar ou atualizar e cancelar

}

9 - Adicionar Item bebida page {
	
	nome da bebida
	quantidade

	botao adicionar ou atualizar e cancelar
}

