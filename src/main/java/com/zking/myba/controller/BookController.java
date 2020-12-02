package com.zking.myba.controller;

import com.google.zxing.WriterException;
import com.zking.myba.model.Book;
import com.zking.myba.service.IBookService;
import com.zking.myba.utils.PageBean;
import com.zking.myba.utils.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class BookController {
    @Autowired
    private IBookService bookService;

    @RequestMapping("/")
    public String list(Model model, Book book, HttpServletRequest req){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(req);
        pageBean.setRows(5);
        List<Book> books=bookService.list(book,pageBean);
        model.addAttribute("books",books);
                return "index";
    }

   @RequestMapping("/toadd")
    public String tobook(Book book){

        return "add";
   }

   @RequestMapping("/doadd")
    public String addBook(Book book){
       int n = bookService.insert(book);
       System.out.println(n);
       if (n>0){
           return "redirect:list";
       }else {
           return "redirect:toadd";
       }
   }

    @RequestMapping("/dodel")
    public String delBook(Book book){

        int n = bookService.deleteByPrimaryKey(book.getBookId());
        if(n>0){
            return "redirect:list";
        }else{
            return "redirect:toadd";
        }
    }

    @RequestMapping("/toUpdate")
    public String load(Model model,Book book){
        Book b = bookService.selectByPrimaryKey(book.getBookId());
        model.addAttribute("b",b);
        return "update";

    }

    @RequestMapping("/doupdate")
    public String update(Book book){
        int n= bookService.updateByPrimaryKey(book);
        if(n>0){
            return "redirect:list";
        }else{
            return "redirect:doUpdate";
        }

    }


    @GetMapping(value="/qrimage")
    public ResponseEntity<byte[]> getQRImage() {

        //二维码内的信息
        String info = "http://172.20.10.3:8080/mybatis01/";

        byte[] qrcode = null;
        try {
            qrcode = QRCodeGenerator.getQRCodeImage(info, 360, 360);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }

        // Set headers
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<byte[]>(qrcode, headers, HttpStatus.CREATED);

    }


    }
