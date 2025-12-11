<?php

namespace App\Http\Controllers;

use App\Mail\ContactoMail;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Mail;

class ConctactoController extends Controller
{
    function enviar(){
        Mail::to("cmr0025@alu.medac.es")->send(new ContactoMail());
        dd("Mensaje envi");
    }
}
