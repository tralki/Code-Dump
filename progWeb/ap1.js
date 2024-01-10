const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res) => {
  res.send('Hello World!')
})


app.get('/sumar', (req, res) => {
    // var a = req.query.batatas;
    // var b = req.query.cenoras;
    // var resultado = a + b;
    res.send('Resultado = ')
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})