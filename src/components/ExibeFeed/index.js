import {Card, CardFrase, CardCantor} from '../FraseCard';
import FontAwesome from 'react-native-vector-icons/FontAwesome';
import {TouchableOpacity, View, ActivityIndicator} from 'react-native';
import React, {useRef, useState} from 'react';
import Share from 'react-native-share';
import ViewShot, {captureRef} from 'react-native-view-shot';
export default function ExibeFeed({dado}) {
  const fraseRef = useRef(null);
  const [loading, setLoading] = useState(false);
  async function shareImage() {
    try {
      setLoading(true);
      const uri = await captureRef(fraseRef, {
        format: 'png',
        quality: 0.8,
      });
      await Share.open({url: uri})
        .then(success => {
          console.log(success);
          setLoading(false);
        })
        .catch(error => {
          console.log(error);
          setLoading(false);
        });
    } catch (error) {
      console.log(error);
      setLoading(false);
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
      {loading ? (
        <ActivityIndicator size={50} color="red" />
      ) : (
        <TouchableOpacity onPress={shareImage}>
          <FontAwesome
            style={{marginTop: 14}}
            name="share-alt"
            color="#000"
            size={40}
          />
        </TouchableOpacity>
      )}
    </View>
  );
}
