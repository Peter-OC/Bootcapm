describe("Pruebas de los ejercicios", () => {
    describe('Ejercicio 1', () => {
        describe('OK', () => {
            it('Genera aleatorio', () => {
                let numRandom = random(1, 100);
                expect(numRandom).toBeGreaterThanOrEqual(1)
                expect(numRandom).toBeLessThanOrEqual(100)
            })
        })

        describe('KO', () => {
            it('Falta parámetro', () => {
                expect(() => random(1), 100).toThrow();
            })
        })

    })

    describe('Ejercicio 5', () => {
        describe('NIF OK', () => {
            ['12345678z', '12345678Z', '1234S', '4g'].forEach(caso => {
                it(`NIF: ${caso}`, () => expect(validaNIF(caso)).toBeTrue())
            })
        })

        describe('NIF KO', () => {
            ['1234J', '12345678', 'Z', 'Z12345678'].forEach(caso => {
                it(`NIF: ${caso}`, () => expect(validaNIF(caso)).toBeFalse())
            })
        })

    })

    describe('Ejercicio 2', () => {
        it('Pendiente')
        
    })


})