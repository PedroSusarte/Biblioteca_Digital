async function carregarLivros() {
  const response = await fetch("http://localhost:8080/livros");
  const livros = await response.json();

  const container = document.getElementById("lista-livros");
  container.innerHTML = "";

  livros.forEach(livro => {
    const div = document.createElement("div");
    div.classList.add("livro");
    div.innerHTML = `
      <strong>${livro.titulo}</strong> - ${livro.autor} (${livro.anoPublicacao})<br>
      <button onclick="alugar('${livro.idLivro}')">Alugar</button>
    `;
    container.appendChild(div);
  });
}

async function alugar(idLivro) {
  const usuario = JSON.parse(localStorage.getItem("usuario"));
  const dataDevolucao = new Date();
  dataDevolucao.setDate(dataDevolucao.getDate() + 7); // devolução em 7 dias

  await fetch("http://localhost:8080/alugueis", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      idUsuario: usuario.idUsuario,
      idLivro: idLivro,
      dataDevolucao: dataDevolucao.toISOString().split('T')[0]
    })
  });

  alert("Livro alugado com sucesso!");
  carregarLivros();
}

function verAlugueis() {
  window.location.href = "alugueis.html";
}

carregarLivros();
