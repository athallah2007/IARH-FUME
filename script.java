function renderCart() {
    const cart = JSON.parse(localStorage.getItem("cart")) || [];
    const emptyMessage = document.getElementById("emptyMessage");
    const cartSummary = document.getElementById("cartSummary");
    cartItemsContainer.innerHTML = "";
    let total = 0;

    if(cart.length === 0) {
        emptyMessage.style.display = "block";
        cartSummary.style.display = "none";
        document.getElementById("checkoutBtn").style.display = "none";
        return;
    } else {
        emptyMessage.style.display = "none";
        cartSummary.style.display = "flex";
        document.getElementById("checkoutBtn").style.display = "block";
    }

    cart.forEach((item, index) => {
        total += item.price * item.qty;
        const itemDiv = document.createElement("div");
        itemDiv.className = "cart-item";

        itemDiv.innerHTML = `
            <img src="${item.image}" alt="${item.name}">
            <div class="item-info">
                <h3>${item.name}</h3>
                <p>Rp ${item.price.toLocaleString()}</p>
                <div class="qty-control">
                    <button onclick="decreaseQty(${index})">-</button>
                    <span>${item.qty}</span>
                    <button onclick="increaseQty(${index})">+</button>
                </div>
            </div>
            <button class="remove-btn" onclick="removeItem(${index})">&times;</button>
        `;

        cartItemsContainer.appendChild(itemDiv);
    });

    cartTotal.textContent = `Rp ${total.toLocaleString()}`;
}
