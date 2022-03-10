const show = () => {
  if (JSON.parse(localStorage.getItem("itemCart"))) {
    let tab = JSON.parse(localStorage.getItem("itemCart")).map((x) => {
      return `<tr>
          <td class="si-pic">
            <img src="/market/img/select-product-1.jpg" alt />
          </td>
          <td class="si-text">
            <div class="product-selected">
              <p>$${x.price} x ${x.qty}</p>
              <h6>${x.name}</h6>
            </div>
          </td>
          <td class="delete-item">
          <a id="removeItem" onclick="removeItem(${x.id})">
            <i class="material-icons">close</i>
          </a>
        </td>
        </tr>`;
    });
    let total = 0;
    JSON.parse(localStorage.getItem("itemCart")).map((x) => {
      return (total = total + x.price * x.qty);
    });
    $(document).ready(function () {
      document.getElementById("cart-body-body").innerHTML = tab;
      document.getElementById("total-purchase").innerHTML = `$` + total;
    });
  }
};

show();

const showCheckout = () => {
  if (JSON.parse(localStorage.getItem("itemCart"))) {
    let tab = JSON.parse(localStorage.getItem("itemCart")).map((x) => {
      return `
        <tr>
          <td class="cart-pic first-row">
            <img src="/market/img/cart-page/product-1.jpg" />
          </td>
          <td class="cart-title first-row text-center">
            <h5>${x.name}</h5>
          </td>
          <td class="p-price first-row">$${x.price}</td>
          <td class="p-price first-row">${x.qty}</td>
          <td class="delete-item">
            <a id="removeItem" onclick="removeItem(${x.id})">
              <i class="material-icons">close</i>
            </a>
          </td>
        </tr>
     `;
    });
    let total = 0;
    JSON.parse(localStorage.getItem("itemCart")).map((x) => {
      return (total = total + x.price * x.qty);
    });
    $(document).ready(function () {
      document.getElementById("checkout-item-page").innerHTML = tab;
      document.getElementById("total-purchase").innerHTML = `$` + total;
    });
  }
};

showCheckout();

const removeItem = (id) => {
  if (JSON.parse(localStorage.getItem("itemCart"))) {
    let data = JSON.parse(localStorage.getItem("itemCart")).filter(
      (x) => x.id !== id.toString()
    );
    localStorage.setItem("itemCart", JSON.stringify(data));
  }
  showCheckout();
  show();
};

// removeItem.onclick = function () {
//   console.log("asd");
// };

// $(document).ready(function () {
//   $("#removeItem").click(function () {
//     if (JSON.parse(localStorage.getItem("itemCart"))) {
//       let data = JSON.parse(localStorage.getItem("itemCart")).filter((x) => x.id !== $(this).attr("data-id"));

//     }
//     console.log($(this).attr("data-id"));
//   });
// });

const addToCart = (id, price, name) => {
  let temp = [];
  let x = JSON.parse(localStorage.getItem("itemCart"));
  let obj;
  if (x) {
    if (x.length > 0) {
      obj = x.find((o) => o.id === id);
      temp = [...x];
    }
  }
  if (obj) {
    temp.map((x) => {
      if (x.id === obj.id) {
        x.qty = x.qty + 1;
      }
    });
  } else {
    temp.push({
      id: id,
      name: name,
      price: parseFloat(price),
      qty: 1,
    });
  }
  localStorage.setItem("itemCart", JSON.stringify(temp));
  show();
};
