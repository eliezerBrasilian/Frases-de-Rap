import {useRoute} from '@react-navigation/native';
import {Container, Header, VoltarTitulo} from './style';
import {FlatList} from 'react-native';
import firestore from '@react-native-firebase/firestore';
import {useEffect, useState} from 'react';
import ExibeFeed from '../../../components/ExibeFeed';
import FontAwesome from 'react-native-vector-icons/FontAwesome';
import {useNavigation} from '@react-navigation/native';
export default CategoriaFeed = () => {
  const [frases, setFrases] = useState(['']);
  const db_frases = firestore().collection('Frases');
  const nav = useNavigation();
  useEffect(() => {
    function loadFrases() {
      const aux = [];
      db_frases
        .where('categoria', '==', route.params.nome_key)
        .get()
        .then(querySnapshot => {
          //console.log('size: ' + querySnapshot.size);
          querySnapshot.forEach(item => {
            aux.push({
              ...item.data(),
              key: item.id,
            });
          });
          setFrases(aux);
        });
    }
    loadFrases();
  });
  const route = useRoute();
  return (
    <Container>
      <Header onPress={() => nav.goBack()}>
        <FontAwesome name="chevron-left" color="#000" size={40} />
        <VoltarTitulo>Voltar</VoltarTitulo>
      </Header>
      <FlatList
        data={frases}
        keyExtractor={item => item.key}
        renderItem={({item}) => <ExibeFeed dado={item} />}></FlatList>
    </Container>
  );
};
