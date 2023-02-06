import {StatusBar, ActivityIndicator} from 'react-native';
import firestore from '@react-native-firebase/firestore';
import {useState, useEffect} from 'react';
import {
  Container,
  TituloEsquerda,
  Titulo,
  BtnProcurarMais,
  BtnProcurarMaisText,
} from './style';
import {strings} from '../../assets/strings';
import {Card, CardFrase, CardCantor} from '../../components/FraseCard';
import Feed from '../Feed';

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
    require('../../assets/images/unsplash_3.jpg'),
    require('../../assets/images/unsplash_4.jpg'),
    require('../../assets/images/unsplash_5.jpg'),
  ]);
  const [imagemAleatoria, setImagemAleatoria] = useState('');
  const [fraseAleatoria, setFraseAleatoria] = useState('');
  const [autorFraseAleatoria, setAutorFraseAleatoria] = useState('');

  const [telaPrincipal, setTelaPrincipal] = useState(true);

  const [loading, setLoading] = useState(true);

  useEffect(() => {
    async function buscaDados() {
      db.onSnapshot(querySnapshot => {
        const aux = [];
        setQtd(querySnapshot.size);

        querySnapshot.forEach(i => {
          aux.push({
            key: i.id,
            ...i.data(),
          });
        });
        setFrases(aux);
        setLoading(false);
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
    function geraFotoAleatoriamente() {
      let index = Math.floor(Math.random() * 5);
      setImagemAleatoria(imagens[index]);
      //setLoading(false);
    }
    geraFotoAleatoriamente();
    buscaDados();
    geraFraseAleatoria();
  }, []);

  function goToFeed() {
    setTelaPrincipal(false);
  }

  if (telaPrincipal)
    return (
      <Container source={imagemAleatoria} resizeMode="cover">
        <StatusBar translucent={true} backgroundColor="transparent" />
        <TituloEsquerda>
          <Titulo>{strings.tituLo}</Titulo>
        </TituloEsquerda>
        {loading ? (
          <ActivityIndicator size={70} color="red" />
        ) : (
          <Card marginTopo={0}>
            <CardFrase>{fraseAleatoria}</CardFrase>
            <CardCantor>{autorFraseAleatoria}</CardCantor>
          </Card>
        )}

        <BtnProcurarMais onPress={goToFeed}>
          <BtnProcurarMaisText>
            {strings.procurar_mais_frases}
          </BtnProcurarMaisText>
        </BtnProcurarMais>
      </Container>
    );
  else return <Feed />;
};
