import {
  Container,
  Titulo,
  TituloEsquerda,
  Categorias,
  CategoriasTitulo,
} from './style';
import {strings} from '../../assets/strings';
import {useEffect, useState} from 'react';
import {FlatList, StatusBar} from 'react-native';
import CategoriasCards from '../CategoriasStack/CategoriasCards';

import firestore from '@react-native-firebase/firestore';
import ExibeFeed from '../../components/ExibeFeed';
export default Feed = () => {
  const categorias_db = firestore().collection('Categorias');
  const frases_db = firestore().collection('Frases');

  useEffect(() => {
    function LoadCategorias() {
      categorias_db.onSnapshot(querySnapshot => {
        const aux = [];
        //console.log('Tamanho: ' + querySnapshot.size);
        querySnapshot.forEach(item => {
          //console.log('Keys(nome): ' + item.id);
          //console.log(item.data().foto);
          aux.push({
            foto: item.data().foto,
            key: item.id,
          });
        });
        setFotos(aux);
      });
    }
    function LoadFrases() {
      frases_db.onSnapshot(querySnapshot => {
        const aux = [];
        querySnapshot.forEach(item => {
          aux.push({
            ...item.data(),
            key: item.id,
          });
        });
        setFrases(aux);
      });
    }
    LoadCategorias();
    LoadFrases();
  }, []);
  const [fotos, setFotos] = useState([]);
  const [frases, setFrases] = useState([]);

  return (
    <Container>
      <StatusBar translucent={true} backgroundColor="transparent" />
      <TituloEsquerda>
        <Titulo>{strings.tituLo}</Titulo>
      </TituloEsquerda>
      <Categorias>
        <TituloEsquerda>
          <CategoriasTitulo>{strings.categorias}</CategoriasTitulo>
          <FlatList
            showsHorizontalScrollIndicator={false}
            horizontal={true}
            data={fotos}
            keyExtractor={item => item.key}
            renderItem={({item}) => <CategoriasCards dado={item} />}></FlatList>
        </TituloEsquerda>
      </Categorias>
      <FlatList
        showsVerticalScrollIndicator={false}
        data={frases}
        keyExtractor={item => item.key}
        renderItem={({item}) => <ExibeFeed dado={item} />}></FlatList>
    </Container>
  );
};
