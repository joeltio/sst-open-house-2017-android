import React from "react";
import { Linking, View, ScrollView, Button, Text, StyleSheet } from "react-native";

import ImageBar from "../components/ImageBar";

import images from "../stores/imageStore";

export default class Home extends React.Component {
    static navigationOptions = {
        title: "Home"
    }

    goToCurriculum() {
        const url = "http://www.sst.edu.sg/learning-sst/academic-course-of-study/"
        Linking.openURL(url).catch(err => console.error('An error occurred', err));
    }

    render() {
        const { navigate } = this.props.navigation;
        const homeBars = [
            [
                "Getting Started",
                images.gettingStarted,
                () => navigate("GettingStarted")
            ],
            [
                "About Us",
                images.aboutUs,
                () => navigate("AboutUs")
            ],
            [
                "Curriculum",
                images.curriculum,
                this.goToCurriculum
            ]
        ].map((e, i) => <ImageBar key={i} text={e[0]} image={e[1]} onPress={e[2]} />);

        return (
            <View style={styles.home}>
                <ScrollView>
                    {homeBars}
                </ScrollView>
            </View>
        )
    }
}

var styles = StyleSheet.create({
  home: {
    justifyContent: "center"
  }
});