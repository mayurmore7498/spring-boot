let invoiceId = null;

// CREATE INVOICE
function createInvoice() {

    const customer = document.getElementById("customer").value;
    const date = document.getElementById("date").value;

    fetch("http://localhost:8080/invoice/create", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            customerName: customer,
            invoiceDate: date,
            totalAmount: 0
        })
    })
    .then(res => res.json())
    .then(data => {
        invoiceId = data.id;
        document.getElementById("invoiceId").innerText =
            "Invoice ID: " + invoiceId;
        alert("Invoice Created");
    });
}

// ADD ITEM
function addItem() {

    if (!invoiceId) {
        alert("Create invoice first!");
        return;
    }

    const product = document.getElementById("product").value;
    const qty = document.getElementById("qty").value;
    const price = document.getElementById("price").value;

    fetch("http://localhost:8080/invoice/item/create", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            product: product,
            quantity: qty,
            price: price,
            invoice: {
                id: invoiceId
            }
        })
    })
    .then(res => res.json())
    .then(() => {
        alert("Item Added");
    });
}

// DOWNLOAD PDF
function downloadPdf() {
    if (!invoiceId) {
        alert("Create invoice first!");
        return;
    }

    window.open(
        "http://localhost:8080/invoice/pdf/" + invoiceId,
        "_blank"
    );
}
