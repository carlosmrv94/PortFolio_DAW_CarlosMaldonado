<?php

namespace App\Http\Controllers;

use App\Models\Carton;
use Illuminate\Http\Request;

class CartonController extends Controller
{
    function guardar(Request $request){
        $c = new Carton();
        $c -> tipo = "linea";
        $c -> numeros = "1,20,55,80,90";

        $c->save();
    }
}
