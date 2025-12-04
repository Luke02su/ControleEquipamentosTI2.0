document.addEventListener("DOMContentLoaded", function () {
  const formCadastro = document.querySelector(".formCadastrar");

  if (formCadastro) { 
      formCadastro.addEventListener("submit", function(event) {
          
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
  }
  const formAtualizar = document.querySelector(".formAtualizar");
  
  if (formAtualizar) {
      formAtualizar.addEventListener("submit", function(event) {
          
          const numSerie = document.getElementById("fk_num_serie").value.trim();
          const tipo = document.getElementById("tipo").value.trim();
          const placa = document.getElementById("placa").value.trim();
          const modelo = document.getElementById("modelo").value.trim();
          const localizacao_atual = document.getElementById("localizacao_atual").value.trim(); 
      
          if (!numSerie || !tipo || !placa || !modelo || !localizacao_atual) {
              return;
          }
      
          const confirmado = confirm("Tem certeza que deseja atualizar este equipamento?");
          if (!confirmado) {
              event.preventDefault();
              alert("Atualização cancelada!"); 
          } else { 
              alert("Atualizado com sucesso!"); 
          }
      });
  }
});