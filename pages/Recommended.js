import React from "react";
import { View, ScrollView, Text, StyleSheet } from "react-native";

import ImageBar from "../components/ImageBar";

import images from "../stores/imageStore";
import defaultStyles from "../stores/styleStore";

import {strings as gettingStarted} from "../stores/gettingStartedStore";
import strings from "../stores/recommendedStore";

import {descriptions, locations } from "../stores/activitiesStore"

export default class Recommended extends React.Component {
    static navigationOptions = {
        title: "Recommended Activities"
    }

    constructor(props) {
        super(props);
        var duration = props.navigation.state.params.duration;
        switch (duration) {
            case gettingStarted.shortDuration:
                this.toIndex = 2;
                break;
            case gettingStarted.mediumDuration:
                this.toIndex = 4;
                break;
            case gettingStarted.longDuration:
                this.toIndex = 5;
                break;
        }
    }

    createImageBar(key, text, image, onPress) {
        return (
            <ImageBar key={key}
                      text={text}
                      image={image}
                      onPress={onPress} />
        );
    }

    render() {
        const { navigate } = this.props.navigation;

        const staticImageBars = [
            [strings.principalTalks, images.principalTalks],
            [strings.studentPanel, images.studentPanel],
            [strings.dsaExercise, images.dsaExercise],
            [strings.handsOnSessions, images.handsOnSessions],
            [strings.ssTedTalks, images.ssTedTalks]
        ].map((e, i) => this.createImageBar(i, e[0], e[1], undefined));

        const imageBars = [
            [
                strings.principalTalks,
                images.principalTalks,
                descriptions.principalTalks,
                locations.principalTalks,
                images.map.floor3up
            ],
            [
                strings.studentPanel,
                images.studentPanel,
                descriptions.studentPanel,
                locations.studentPanel,
                images.map.floor3up
            ],
            [
                strings.dsaExercise,
                images.dsaExercise,
                descriptions.dsaExercise,
                locations.dsaExercise,
                images.map.floor3up
            ],
            [
                strings.handsOnSessions,
                images.handsOnSessions,
                descriptions.handsOnSessions,
                locations.handsOnSessions,
                images.map.floor2
            ],
            [
                strings.ssTedTalks,
                images.ssTedTalks,
                descriptions.ssTedTalks,
                locations.ssTedTalks,
                images.map.floor3up
            ]
        ].map((e, i) => this.createImageBar(i, e[0], e[1],
            () => {
                var p = {
                    imageBar: staticImageBars[i],
                    description: e[2],
                    location: e[3],
                    locationImage: e[4]
                }

                navigate("ActivityInfo", p);
            }
        ));

        var viewImageBars = imageBars.slice(0, this.toIndex);

        return (
            <ScrollView style={styles.recommended}>
                <Text style={defaultStyles.header}>Welcome.</Text>
                <Text style={defaultStyles.description}>Based on your duration of stay, we recommend the following activities</Text>
                {viewImageBars}
            </ScrollView>
        );
    }
}

var styles = StyleSheet.create({
    recommended: {
        flex: 1,
        backgroundColor: "white"
    }
});