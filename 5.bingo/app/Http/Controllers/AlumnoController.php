<?php

// app/Http/Controllers/AlumnoController.php
namespace App\Http\Controllers;

use App\Models\Alumno;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;

class AlumnoController extends Controller
{
    public function create()
    {
        return view('alumnos.create');
    }

    public function store(Request $request)
    {
        $request->validate([
            'nombre' => 'required|string|max:255',
            'apellidos' => 'required|string|max:255',
            'email' => 'required|string|max:255',
            'password' => 'required|string|min:8|confirmed',
            'idaula' => 'required|integer'
        ]);

        Alumno::create([
            'nombre' => $request->nombre,
            'apellidos' => $request->apellidos,
            'email' => $request->email,
            'password' => Hash::make($request->password), // Encriptar la contraseña
            'idaula' => $request->idaula
        ]);

        return redirect()->route('alumnos.create')->with('success', 'Alumno guardado con éxito');
    }
}
