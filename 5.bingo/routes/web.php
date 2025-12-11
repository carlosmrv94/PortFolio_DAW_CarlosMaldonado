<?php

use App\Http\Controllers\AulaController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\CartonController;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/probando', function () {
    return view('probando');
});

Route::get('/aula/{i}', [AulaController::class, 'index']); 

Route::get('/', [CartonController::class, 'guardar']); 

