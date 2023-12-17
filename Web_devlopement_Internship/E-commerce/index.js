document.addEventListener("DOMContentLoaded", function () {
  let cartCount = 0;

  function addToCart(button) {
    cartCount++;

    updateCartCount();

    let box = button.closest(".box-content");

    let itemName = box.querySelector("h2").textContent;
    let itemPrice = box.querySelector(".paragraph").textContent;

    updateItemDetails(itemName, itemPrice);
  }

  function buyNow(button) {
    cartCount++;

    updateCartCount();

    let box = button.closest(".box-content");

    let itemName = box.querySelector("h2").textContent;
    let itemPrice = box.querySelector(".paragraph").textContent;

    updateItemDetails(itemName, itemPrice);

    alert("Redirecting to checkout...");
  }

  function updateCartCount() {
    let cartCountElement = document.getElementById("cart-count");
    if (cartCountElement) {
      cartCountElement.textContent = cartCount;
    }
  }

  function updateItemDetails(name, price) {
    let itemNameElement = document.getElementById("item-name");
    let itemPriceElement = document.getElementById("item-price");

    if (itemNameElement && itemPriceElement) {
      itemNameElement.textContent = "Product Name: " + name;
      itemPriceElement.textContent = "Price: " + price;
    }
  }

  // Attach click event listeners to the buttons
  let addToCartButtons = document.querySelectorAll(".butm button:nth-child(2)");
  let buyNowButtons = document.querySelectorAll(".butm button:nth-child(1)");

  addToCartButtons.forEach(function (button) {
    button.addEventListener("click", function () {
      addToCart(button);
    });
  });

  buyNowButtons.forEach(function (button) {
    button.addEventListener("click", function () {
      buyNow(button);
    });
  });
});
