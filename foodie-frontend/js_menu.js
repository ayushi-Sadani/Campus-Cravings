let selectedItems = [];

window.onload = async () => {
  const res = await fetch("http://localhost:8080/api/menu");
  const items = await res.json();

  const container = document.getElementById("menuItems");
  items.forEach(item => {
    const div = document.createElement("div");
    div.className = "menu-item";
    div.innerHTML = `
      <img src="${item.imageUrl}" alt="${item.name}" />
      <h3>${item.name}</h3>
      <p>₹${item.price}</p>
      <input type="checkbox" value="${item.id}" />
    `;
    container.appendChild(div);
  });
};

document.getElementById("orderBtn").addEventListener("click", async () => {
  const checked = document.querySelectorAll("input[type='checkbox']:checked");
  const ids = Array.from(checked).map(cb => parseInt(cb.value));

  const res = await fetch("http://localhost:8080/api/order", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ itemIds: ids })
  });

  const msg = document.getElementById("message");
  msg.innerText = res.ok ? "Order placed successfully!" : "Order failed.";
});