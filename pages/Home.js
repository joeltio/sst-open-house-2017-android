import React from "react";
import { Linking, View, ScrollView, Button, Text, StyleSheet } from "react-native";

import ImageBar from "../components/ImageBar";

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
                require("../resources/img/getting_started.jpg"),
                {width:1594, height:811},
                () => navigate("GettingStarted")
            ],
            [
                "About Us",
                require("../resources/img/about_us.jpg"),
                {width: 2426, height:1671},
                () => navigate("AboutUs")
            ],
            [
                "Curriculum",
                require("../resources/img/curriculum.jpg"),
                {width: 3472, height:2315 },
                this.goToCurriculum
            ]
        ].map((e, i) => <ImageBar key={i} text={e[0]} src={e[1]} dimen={e[2]} press={e[3]} />);

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