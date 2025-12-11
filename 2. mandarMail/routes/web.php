<?php

use App\Http\Controllers\ConctactoController;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/enviar', [ConctactoController::class, 'enviar']);
