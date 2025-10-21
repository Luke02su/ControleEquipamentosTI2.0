document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll(".btnCadastrar").forEach(botao => {
      botao.addEventListener("click", function(event) {
        const confirmado = confirm("Tem certeza que deseja cadastrar?");
        if (!confirmado) {
          event.preventDefault();
          alert("Cadastramento cancelado!");
        } else {
          alert("Cadastrado com sucesso!");
        }
      });
    });
  });

  document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll(".btnAtualizar").forEach(botao => {
      botao.addEventListener("click", function(event) {
        const confirmado = confirm("Tem certeza que deseja atualizar?");
        if (!confirmado) {
          event.preventDefault();
          alert("Atualização cancelada!");
        } else {
          alert("Atualizado com sucesso!");
        }
      });
    });
  });

  document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll(".btnSalvar").forEach(botao => {
      botao.addEventListener("click", function(event) {
        const confirmado = confirm("Tem certeza que deseja descartar?");
        if (!confirmado) {
          event.preventDefault();
          alert("Descartamento cancelado!");
        } else {
          alert("Desartado com sucesso!");
        }
      });
    });
  });

  document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll(".btnSalvar").forEach(botao => {
      botao.addEventListener("click", function(event) {
        const confirmado = confirm("Tem certeza que deseja deletar?");
        if (!confirmado) {
          event.preventDefault();
          alert("Deletamento cancelado!");
        } else {
          alert("Deletado com sucesso!");
        }
      });
    });
  });
