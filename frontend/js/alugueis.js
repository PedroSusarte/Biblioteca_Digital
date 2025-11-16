async function carregarAlugueis() {
    const usuario = JSON.parse(localStorage.getItem("usuarioLogado"));
    if (!usuario) {
        alert("Você precisa estar logado!");
        window.location.href = "login.html";
        return;
    }

    const response = await fetch(`http://localhost:8080/alugueis/usuario/${usuario.idUsuario}`);
    const alugueis = await response.json();

    const lista = document.getElementById("listaAlugueis");
    lista.innerHTML = "";

    if (alugueis.length === 0) {
        lista.innerHTML = "<p>Nenhum aluguel encontrado.</p>";
        return;
    }

    alugueis.forEach(a => {
        const item = document.createElement("div");
        item.classList.add("aluguel-item");
        item.innerHTML = `
            <h3>${a.idAluguel}</h3>
            <p><strong>Livro:</strong> ${a.idLivro}</p>
            <p><strong>Data do aluguel:</strong> ${a.dataAluguel}</p>
            <p><strong>Status:</strong> ${a.status}</p>
        `;
        lista.appendChild(item);
    });
}

carregarAlugueis();