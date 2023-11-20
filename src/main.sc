require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        script:
            $response.replies = $response.replies || [];
            $response.replies.push({
                "type": "text",
                "text": "<a href='https://ya.ru'>Link</a>",
                "markup": "html"
            });

    state: Hello
        intent!: /привет
        a: Привет

    state: Bye
        intent!: /пока
        a: Пока

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}

    state: KnowledgeBase
        intentGroup!: /KnowledgeBase
        script:
            $faq.pushReplies();
