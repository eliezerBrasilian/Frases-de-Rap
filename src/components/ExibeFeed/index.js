import {Card, CardFrase, CardCantor} from '../FraseCard';
import FontAwesome from 'react-native-vector-icons/FontAwesome';
import {TouchableOpacity, View} from 'react-native';
import {useRef} from 'react';
import Share from 'react-native-share';
import ViewShot, {captureRef} from 'react-native-view-shot';
export default function ExibeFeed({dado}) {
  const fraseRef = useRef(null);
  async function shareImage() {
    try {
      const uri = await captureRef(fraseRef, {
        format: 'png',
        quality: 0.8,
      });
      await Share.open({url: uri})
        .then(success => {
          console.log(success);
        })
        .catch(error => {
          console.log(error);
        });
    } catch (error) {
      console.log(error);
    }
  }
  return (
    <View
      style={{
        alignItems: 'center',
        justifyContent: 'center',
        marginHorizontal: 19,
      }}>
      <Card marginTopo={18} ref={fraseRef}>
        <CardFrase>{dado.frase}</CardFrase>
        <CardCantor>{dado.cantor}</CardCantor>
      </Card>
      <TouchableOpacity onPress={shareImage}>
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
