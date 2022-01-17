<template>
  <v-app>
    <v-system-bar app>
      <v-spacer></v-spacer>

      <v-icon>mdi-square</v-icon>

      <v-icon>mdi-circle</v-icon>

      <v-icon>mdi-triangle</v-icon>
    </v-system-bar>

    <v-navigation-drawer
        v-model="drawer"
        src="https://picsum.photos/800"
        app
        dark
    >
      <v-sheet
          color="grey lighten-4"
          class="pa-4"
      >
          <v-avatar
              class="mb-4"
              color="grey darken-1"
              size="64"
          ></v-avatar>

        <div>Lily Kim</div>
      </v-sheet>

      <v-divider></v-divider>

      <v-list
          shaped
          color="rgba(0, 0, 0, 0.3)"
      >
        <v-list-item href>
          <v-list-item-icon>
            <v-icon>mdi-home</v-icon>
          </v-list-item-icon>

          <v-list-item-title>About</v-list-item-title>
        </v-list-item>

        <v-list-group
            :value="true"
            prepend-icon="mdi-account-circle"
        >
          <template v-slot:activator>
            <v-list-item-title>Studylog</v-list-item-title>
          </template>

          <v-list-group
              :value="true"
              no-action
              sub-group
          >
            <template v-slot:activator>
              <v-list-item-content>
                <v-list-item-title>CS</v-list-item-title>
              </v-list-item-content>
            </template>

            <v-list-item
                v-for="([title, icon], i) in cs"
                :key="i"
                link
            >
              <v-list-item-title v-text="title"></v-list-item-title>

              <v-list-item-icon>
                <v-icon v-text="icon"></v-icon>
              </v-list-item-icon>
            </v-list-item>
          </v-list-group>

          <v-list-group
              no-action
              sub-group
          >
            <template v-slot:activator>
              <v-list-item-content>
                <v-list-item-title>Java</v-list-item-title>
              </v-list-item-content>
            </template>

            <v-list-item
                v-for="([title, icon], i) in java"
                :key="i"
                link
            >
              <v-list-item-title v-text="title"></v-list-item-title>

              <v-list-item-icon>
                <v-icon v-text="icon"></v-icon>
              </v-list-item-icon>
            </v-list-item>
          </v-list-group>

          <v-list-group
              :value="true"
              no-action
              sub-group
          >
            <template v-slot:activator>
              <v-list-item-content>
                <v-list-item-title>Certificate</v-list-item-title>
              </v-list-item-content>
            </template>

            <v-list-item
                v-for="([title, icon], i) in certificate"
                :key="i"
                link
            >
              <v-list-item-title v-text="title"></v-list-item-title>

              <v-list-item-icon>
                <v-icon v-text="icon"></v-icon>
              </v-list-item-icon>
            </v-list-item>
          </v-list-group>
        </v-list-group>

        <v-list-item>
          <v-list-item-icon>
            <v-icon>mdi-home</v-icon>
          </v-list-item-icon>

          <v-list-item-title>Journal</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-main>
      <router-view></router-view>
      <hello-world/>
<!--      <v-container-->
<!--          class="py-8 px-6"-->
<!--          fluid-->
<!--      >-->
<!--        <v-row>-->
<!--          <v-col-->
<!--              v-for="card in cards"-->
<!--              :key="card"-->
<!--              cols="12"-->
<!--          >-->
<!--            <v-card>-->
<!--              <v-subheader>{{ card }}</v-subheader>-->

<!--              <v-list two-line>-->
<!--                <template v-for="n in 6">-->
<!--                  <v-list-item-->

<!--                      :key="n"-->
<!--                  >-->
<!--                    <v-list-item-avatar color="grey darken-1">-->
<!--                    </v-list-item-avatar>-->

<!--                    <v-list-item-content>-->
<!--                      <v-list-item-title>Message {{ n }}</v-list-item-title>-->

<!--                      <v-list-item-subtitle>-->
<!--                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nihil repellendus distinctio similique-->
<!--                      </v-list-item-subtitle>-->
<!--                    </v-list-item-content>-->
<!--                  </v-list-item>-->

<!--                  <v-divider-->
<!--                      v-if="n !== 6"-->
<!--                      :key="`divider-${n}`"-->
<!--                      inset-->
<!--                  ></v-divider>-->
<!--                </template>-->
<!--              </v-list>-->
<!--            </v-card>-->
<!--          </v-col>-->
<!--        </v-row>-->
<!--      </v-container>-->
    </v-main>
    <v-footer padless>
      <v-col
          class="text-center"
          cols="12"
      >
        {{ new Date().getFullYear() }} — <strong>Vuetify</strong>
      </v-col>
    </v-footer>
  </v-app>

</template>

<script>

export default {
  components: {
    HelloWorld,
  },
  data: () => ({
    cards: ['Today', 'Yesterday'],
    drawer: null,
    links: [
      ['mdi-inbox-arrow-down', 'About'],
      ['mdi-send', 'Studylog'],
      ['mdi-delete', 'Journal'],
      ['mdi-alert-octagon', 'Spam'],
    ],
    cs: [
        ['Computer Science', 'mdi-send']
    ],
    java: [
        ['Java', 'mdi-send'],
        ['Spring', 'mdi-send'],
        ['ETC', 'mdi-send'],
    ],
    certificate: [
        ['정보처리기사', 'mdi-send']
    ]
  }),
}

import HelloWorld from './components/HelloWorld';
//
// export default {
//   name: 'App',
//
//   components: {
//     HelloWorld,
//   },
//
//   data: () => ({
//     //
//   }),
// };
</script>
