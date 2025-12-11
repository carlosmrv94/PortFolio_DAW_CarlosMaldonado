<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Aula>
 */
class AulaFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {


        $asignaturas = [
            "Matemáticas 1º",
            "Lengua y Literatura 1º",
            "Ciencias Sociales 1º",
            "Ciencias Naturales 1º",
            "Educación Física 1º",
            "Inglés 1º",
            "Matemáticas 2º",
            "Lengua y Literatura 2º",
            "Ciencias Sociales 2º",
            "Ciencias Naturales 2º",
            "Educación Física 2º",
            "Inglés 2º",
            "Matemáticas 3º",
            "Lengua y Literatura 3º",
            "Historia 3º",
            "Biología 3º",
            "Educación Física 3º",
            "Inglés 3º",
            "Matemáticas 4º",
            "Lengua y Literatura 4º",
            "Geografía 4º",
            "Física 4º",
            "Educación Física 4º",
            "Inglés 4º",
            "Matemáticas 5º",
            "Lengua y Literatura 5º",
            "Química 5º",
            "Historia 5º",
            "Física 5º",
            "Educación Física 5º",
            "Inglés 5º",
            "Matemáticas 6º",
            "Lengua y Literatura 6º",
            "Filosofía 6º",
            "Historia 6º",
            "Química 6º",
            "Educación Física 6º",
            "Inglés 6º",
            "Matemáticas Avanzadas",
            "Lengua y Literatura Avanzada",
            "Arte y Cultura",
            "Economía",
            "Psicología",
            "Programación",
            "Música",
            "Tecnología",
            "Francés",
            "Emprendimiento",
            "Derecho",
            "Biología Avanzada"
        ];



        return [
            'nombre' => fake() -> randomElement($asignaturas),
            'capacidad' => fake()->numberBetween(20, 30)
        ];
    }
}
