document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector(".formCadastro");
  
    form.addEventListener("submit", function(event) {
      const numSerie = document.getElementById("fk_num_serie").value.trim();
      const tipo = document.getElementById("tipo").value.trim();
      const placa = document.getElementById("placa").value.trim();
      const modelo = document.getElementById("modelo").value.trim();
      const localizacao_atual = document.getElementById("localizacao_atual").value.trim();
  
      if (!numSerie || !tipo || !placa || !modelo || !localizacao_atual) {
        return;
      }
  
      const confirmado = confirm("Tem certeza que deseja cadastrar este equipamento?");
      if (!confirmado) {
        event.preventDefault();
        alert("Cadastramento cancelado!");
      } else { 
        alert("Cadastrado com sucesso!");
      }
    });
  });
  

  document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector(".formAtualizar");
  
    form.addEventListener("submit", function(event) {
      const numSerie = document.getElementById("fk_num_serie").value.trim();
      const tipo = document.getElementById("tipo").value.trim();
      const placa = document.getElementById("placa").value.trim();
      const modelo = document.getElementById("modelo").value.trim();
      const localizacao_atual = documento.getElementById("localizacao_atual").value.trim()
  
      if (!numSerie || !tipo || !placa || !modelo || !localizacao_atual) {
        return;
      }
  
      const confirmado = confirm("Tem certeza que deseja atualizar este equipamento?");
      if (!confirmado) {
        event.preventDefault();
        alert("Cadastramento cancelado!");
      } else { 
        alert("Cadastrado com sucesso!");
      }
    });
  });