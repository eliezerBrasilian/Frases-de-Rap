import {Card, CardFrase, CardCantor} from '../FraseCard';
import FontAwesome from 'react-native-vector-icons/FontAwesome';
import {TouchableOpacity, View} from 'react-native';
export default function ExibeFeed({dado}) {
  return (
    <View
      style={{
        alignItems: 'center',
        justifyContent: 'center',
        marginHorizontal: 19,
      }}>
      <Card marginTopo={18}>
        <CardFrase>{dado.frase}</CardFrase>
        <CardCantor>{dado.cantor}</CardCantor>
      </Card>
      <TouchableOpacity>
        <FontAwesome
          style={{marginTop: 14}}
          name="share-alt"
          color="#000"
          size={40}
        />
      </TouchableOpacity>
    </View>
  );
}
