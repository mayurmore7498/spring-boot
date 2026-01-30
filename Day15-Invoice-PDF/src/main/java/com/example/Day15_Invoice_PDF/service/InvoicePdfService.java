package com.example.Day15_Invoice_PDF.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Day15_Invoice_PDF.model.Invoice;
import com.example.Day15_Invoice_PDF.model.InvoiceItem;
import com.example.Day15_Invoice_PDF.repository.InvoiceItemRepository;
import com.example.Day15_Invoice_PDF.repository.InvoiceRepository;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class InvoicePdfService {

    @Autowired
    private InvoiceRepository invoiceRepo;

    @Autowired
    private InvoiceItemRepository itemRepo;

    public ByteArrayInputStream generateInvoice(Long invoiceId) {

        Invoice invoice = invoiceRepo.findById(invoiceId).get();
        List<InvoiceItem> items = itemRepo.findByInvoiceId(invoiceId);

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // ===== LOGO =====
            Image logo = Image.getInstance("src/main/resources/logo.png");
            logo.scaleToFit(120, 60);
            logo.setAlignment(Image.ALIGN_LEFT);
            document.add(logo);

            // ===== TITLE =====
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("INVOICE", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph(" "));

            // ===== INVOICE DETAILS =====
            document.add(new Paragraph("Invoice ID: " + invoice.getId()));
            document.add(new Paragraph("Customer Name: " + invoice.getCustomerName()));
            document.add(new Paragraph("Invoice Date: " + invoice.getInvoiceData()));

            document.add(new Paragraph(" "));

            // ===== TABLE =====
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);

            table.addCell("Product");
            table.addCell("Quantity");
            table.addCell("Price");
            table.addCell("Total");

            double grandTotal = 0;

            for (InvoiceItem item : items) {
                double total = item.getQuantity() * item.getPrice();
                grandTotal += total;

                table.addCell(item.getProduct());
                table.addCell(String.valueOf(item.getQuantity()));
                table.addCell(String.valueOf(item.getPrice()));
                table.addCell(String.valueOf(total));
            }

            document.add(table);

            document.add(new Paragraph(" "));

            // ===== GRAND TOTAL =====
            Font totalFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            document.add(new Paragraph("Grand Total: ₹ " + grandTotal, totalFont));

            document.add(new Paragraph(" "));

            // ===== FOOTER =====
            Paragraph footer = new Paragraph(
                    "Thank you for your business!",
                    FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 10));
            footer.setAlignment(Element.ALIGN_CENTER);

            document.add(footer);

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
