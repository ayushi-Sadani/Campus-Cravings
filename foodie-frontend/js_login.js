document.getElementById("loginForm").addEventListener("submit", async (e) => {
  e.preventDefault();
  const username = document.getElementById("username").value;
  const password = document.getElementById("password").value;

  const res = await fetch("http://localhost:8080/api/auth/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ username, password })
  });

  const result = document.getElementById("loginResult");
  if (res.ok) {
    result.innerText = await res.text();
    result.style.color = "green";
    setTimeout(() => window.location.href = "orders.html", 1000);
  } else {
    result.innerText = await res.text();
    result.style.color = "red";
  }
});
