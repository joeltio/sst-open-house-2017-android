import React from "react";

import ImageBar from "../components/ImageBar";

export default class Recommended extends React.Component {
    render() {
        const principalTalks = <ImageBar />;
        const studentPanel = <ImageBar />;
        const dsaExercise = <ImageBar />;
        const handsOnSessions = <ImageBar />;
        const ssTedTalks = <ImageBar />;

        return (
            <View>
                <Text>Welcome.</Text>
                <Text>Based on your duration of stay, we recommend the following activities</Text>
            </View>
        );
    }
}