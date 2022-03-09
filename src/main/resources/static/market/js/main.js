const removeItem = (id) => {
  console.log("pelin", id);
};

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
