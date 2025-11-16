async function login() {
  const email = document.getElementById("email").value;
  const senha = document.getElementById("senha").value;

  const response = await fetch("http://localhost:8080/usuarios");
  const usuarios = await response.json();

  const usuario = usuarios.find(u => u.email === email && u.senha === senha);

  if (usuario) {
    localStorage.setItem("usuarioLogado", JSON.stringify(usuario)); // ✅ Agora salva com o nome correto
    window.location.href = "livros.html";
  } else {
    document.getElementById("mensagem").innerText = "Usuário ou senha inválidos!";
  }
}
