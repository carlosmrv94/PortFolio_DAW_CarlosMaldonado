<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Carton extends Model
{
    protected $table = "carton";
    protected $primary = "id";
    protected $fillable = [
        'tipos',
        'numeros'
    ];
}
