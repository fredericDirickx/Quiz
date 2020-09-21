class QuizRepository {

    data;


    getAllQuizId() {

        var result = []
        for (var i = 0; i < this.data.length; i++) {
            result.push(this.data[i].id);
        }
        return result;
    }

    getAllQuizDate() {

        var result = []
        for (var i = 0; i < this.data.length; i++) {
            result.push(this.data[i].date);
        }
        return result;
    }


    getAllQuestions() {
        var result = [];

        for (var i = 0; i < this.data.length; i++) {
            for (const question of this.data[i].questions) {

                result.push(question.operandFirst + " " + question.operator + " " + question.operandSecond);

            }
        }
        return result;
    }


    getAllAnswersDuration() {
        var result = [];

        for (var i = 0; i < this.data.length; i++) {
            for (const question of this.data[i].questions) {

                result.push(this.calculateDuration(question.answer.startTime, question.answer.endTime));

            }
        }
        return result;
    }

    calculateDuration(startDate, endDate) {
        var duration = moment.duration(moment(endDate).diff(moment(startDate)));
        return duration.as('seconds');
    }




    getMaxDurationAnswerPerQuiz() {
        var result = [];

        for (var i = 0; i < this.data.length; i++) {
            var duration = 0;
            for (const question of this.data[i].questions) {
                duration = Math.max(this.calculateDuration(question.answer.startTime, question.answer.endTime), duration);
            }
            result.push(duration);
        }
        return result;

    }

    getMinDurationAnswerPerQuiz() {
        var result = [];

        for (var i = 0; i < this.data.length; i++) {
            var duration = 1000;
            for (const question of this.data[i].questions) {
                duration = Math.min(this.calculateDuration(question.answer.startTime, question.answer.endTime), duration);
            }
            result.push(duration);
        }
        return result;

    }


    getAmountOfCorrectAnswers() {
        var amountOfCorrectAnswers = 0;
        var amountOfQuestions = 0;

        var result = [];

        for (var i = 0; i < this.data.length; i++) {

            amountOfQuestions+= this.data[i].amountQuestions;

            for (const question of this.data[i].questions) {
                if(this.correctAnswer(question) == question.answer.answer){
                    amountOfCorrectAnswers++
                }
            }
        }


        result.push(amountOfCorrectAnswers);
        result.push(amountOfQuestions-amountOfCorrectAnswers);



        return result;
    }


    correctAnswer(question){

        switch (question.operator){
            case "*":
                return question.operandFirst * question.operandSecond;
            case "+":
                return question.operandFirst + question.operandSecond;
            case "-":
                return question.operandFirst - question.operandSecond;
            case "+":
                return question.operandFirst / question.operandSecond;

        }

    }


    getCorrectAnswerPerQuiz(){
        var amountOfCorrectAnswers = 0;
        var amountOfCorrectAnswersArray = [];
        var amountOfQuestions = 0;
        var amountOfQuestionsArray = [];

        var result = [];


        for (var i = 0; i < this.data.length; i++) {



            for (const question of this.data[i].questions) {
                if(this.correctAnswer(question) == question.answer.answer){
                    amountOfCorrectAnswers++
                }
            }
            amountOfCorrectAnswersArray.push(amountOfCorrectAnswers);
            amountOfQuestionsArray.push(this.data[i].amountQuestions - amountOfCorrectAnswers);
            amountOfCorrectAnswers = 0;

        }


        result.push(amountOfCorrectAnswersArray,amountOfQuestionsArray);




        return result;

    }






}