//incrementa
var botoesIncrementa = document.querySelectorAll(".btn-incrementa");
for (let botao of botoesIncrementa){
    botao.addEventListener('click', incrementa);
    function incrementa()
    {
        var item = botao.closest('.item');
        var input = item.querySelector('.quantidade');
        input.value++;

        var preco = pegaPrecoItem(item);
        adicionaAoTotal(preco);
        var caloriaUnidade = pegaQtdCalorias(item);
        adicionaAoTotalCalorias(caloriaUnidade);
    }
}

//decrementa
var botoesDecrementa = document.querySelectorAll(".btn-decrementa");
for (let botao of botoesDecrementa)
{
    botao.addEventListener('click', decrementa);
    function decrementa() {
        var item = botao.closest('.item');
        var input = item.querySelector('.quantidade');
        
        if (input.value > 0) {
            input.value--;
            var preco = pegaPrecoItem(item);
            adicionaAoTotal(-preco);
            var caloriaUnidade = pegaQtdCalorias(item);
            adicionaAoTotalCalorias(-caloriaUnidade);
        } else
        {
            console.log(input.value);
        }
    }
}

var formPedido = document.forms.pedido;
formPedido.addEventListener('submit', function (event) {

    var contador = 0;
    var inputs = formPedido.querySelectorAll("input.quantidade");

    for (let input of inputs)
    {
        if (input.value > 0)
        {
            contador++;
        }
    }

    if (contador == 0)
    {
        alert("Deve ter pelo menos 1 item no pedido");
        event.preventDefault();
    }
});

//funções auxiliares
function pegaPrecoItem(item) {
    var precoItem = item.querySelector('.preco-item');
    return formata2Casas(parseFloat(precoItem.textContent));
}

function adicionaAoTotal(valor) {
    var elementoTotal = document.querySelector("#total");
    elementoTotal.textContent = formata2Casas(valor + parseFloat(elementoTotal.textContent));
}

function pegaQtdCalorias(caloria) {
    var calorias = caloria.querySelector('.calorias-item');
    return Number(calorias.textContent);
}

function adicionaAoTotalCalorias(totalCalorias) {
    var caloriasTotal = document.querySelector("#totalCalorias");
    caloriasTotal.textContent = totalCalorias + Number(caloriasTotal.textContent);
}

function formata2Casas(num){
    return Math.round(num*100)/100;
}