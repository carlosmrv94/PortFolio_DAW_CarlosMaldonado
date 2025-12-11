<?php

namespace App\Http\Controllers;

use App\Models\Aula;
use App\Models\Alumno;
use Illuminate\Http\Request;

class AulaController extends Controller
{
    function index($i){
        $alumnos = Alumno::where("idaula",$i)->get();
        $aula = Aula::where("id",$i)->first();
        return view('alumnos')->with(['aula' => $aula, 'alumnos'=>$alumnos]);
    }
}
