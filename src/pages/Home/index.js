import {Button, View, Text, StatusBar, SafeAreaView} from 'react-native';
import firestore from '@react-native-firebase/firestore';
import {useState, useEffect} from 'react';
import {Container, Titulo} from './style';
import {strings} from '../../assets/strings';
import {Card, CardFrase, CardCantor} from '../../components';

export default Home = () => {
  const [frases, setFrases] = useState([]);
  const db = firestore().collection('Frases');
  let [qtd, setQtd] = useState(0);

  const [fraseReserva, setFraseReserva] = useState([
    {frase: 'Toda de Gucci, ela só anda chique.', cantor: 'Jé Santiago'},
    {
      frase: 'Essa party tá lotada porquê que é o pai que tá no fly.',
      cantor: 'Derek',
    },
    {frase: 'Vagabundo quer e quem não quer, né.', cantor: 'Haikaiss'},
    {frase: 'O nosso destino é uma caixa de surpresa.', cantor: 'Haikaiss'},
    {frase: 'Respeito todos, menos os vacilão.', cantor: 'Dfideliz'},
  ]);
  const [imagens, setImagens] = useState([
    require('../../assets/images/unsplash_1.jpg'),
    require('../../assets/images/unsplash_2.jpg'),
  ]);
  const [fraseAleatoria, setFraseAleatoria] = useState('');
  const [autorFraseAleatoria, setAutorFraseAleatoria] = useState('');

  useEffect(() => {
    async function buscaDados() {
      db.onSnapshot(querySnapshot => {
        const aux = [];

        //dentro da collection Frases
        //.log('quantidade: ' + querySnapshot.size);
        setQtd(querySnapshot.size);
        //percorrendo os vetores (keys)
        querySnapshot.forEach(i => {
          //no primeiro console eu consigo friamente obter os nomes desses vetores (suas keys)
          console.log('key: ' + i.id + ' frase: ' + i.data().frase);
          //ja nesse segundo console eu entrei dentro do vetor e acessei a propriedade frase

          aux.push({
            key: i.id,
            ...i.data(),
          });
        });
        setFrases(aux);
      });
    }
    function geraFraseAleatoria() {
      db.onSnapshot(q => {
        const aux = [];
        frases.map(i => {
          console.log('\nfrase: ' + i.frase);
          aux.push(i.frase);
        });
        if (aux.frase === undefined) {
          let index = Math.floor(Math.random() * fraseReserva.length);
          setFraseAleatoria(fraseReserva[index].frase);
          setAutorFraseAleatoria(fraseReserva[index].cantor);
        } else setFraseAleatoria(aux[Math.floor(Math.random() * q.size)]);
      });
    }
    buscaDados();
    geraFraseAleatoria();
  }, []);

  function randomFrase() {}
  return (
    <Container source={imagens[0]} resizeMode="cover">
      <StatusBar translucent={true} backgroundColor="transparent" />
      <Titulo>{strings.tituLo}</Titulo>
      <Card>
        <CardFrase>{fraseAleatoria}</CardFrase>
        <CardCantor>{autorFraseAleatoria}</CardCantor>
      </Card>
    </Container>
  );
};
