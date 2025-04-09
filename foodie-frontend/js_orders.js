window.onload = async () => {
  const res = await fetch("http://localhost:8080/api/order/all");
  const orders = await res.json();

  const container = document.getElementById("ordersContainer");
  orders.forEach(order => {
    const card = document.createElement("div");
    card.className = "order-card";
    card.innerHTML = `
      <p><strong>ID:</strong> ${order.id}</p>
      <p><strong>Time:</strong> ${order.orderTime}</p>
      <p><strong>Items:</strong> ${order.itemsJson}</p>
      <p><strong>Total:</strong> ₹${order.totalPrice}</p>
    `;
    container.appendChild(card);
  });
};