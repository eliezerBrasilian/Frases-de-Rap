import {Button, View} from 'react-native';
import firestore from '@react-native-firebase/firestore';
import {useState, useEffect} from 'react';

export default Home = () => {
  const [frases, setFrases] = useState([]);
  const db = firestore().collection('Frases');
  let [qtd, setQtd] = useState(0);
  let fraseAleatoria = '';

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
        aux.map(j => {
          console.log('j-frase: ' + j.frase);
          console.log('j.key: ' + j.key);
        });
        console.log('Quantidade: ' + qtd);
        setFrases(aux);
      });
    }
    buscaDados();
  }, []);

  function randomFrase() {
    fraseAleatoria = frases[Math.floor(Math.random() * qtd)];
    console.log('Frase aleatoria: ' + fraseAleatoria.frase);
    console.log('Quantidade: ' + qtd);
  }
  return (
    <View style={{flex: 1}}>
      <Button onPress={randomFrase} title="Random frase" />
    </View>
  );
};
