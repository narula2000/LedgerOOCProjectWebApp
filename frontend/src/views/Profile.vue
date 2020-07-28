
<template>
  <v-app id="inspire" class="theme--light">
   

   <v-container grid-list-xl>
     <v-row
      align="center"
      justify="center"
    >
    <h1 center> User Profile </h1>
    </v-row>
    <br>
    <br>
<v-layout >
    <v-flex xs12 md4>
      <v-card color="white" height=500>
           <v-row
          align="center"
          justify="center"
        ><v-col
          align="center"
          justify="center"
        >
        <v-btn width="125" height="450" to="/history" color="black" dark outlined>User History </v-btn>
        <br>
        </v-col>
        </v-row>
      </v-card>
    </v-flex>

    <v-flex xs12 md4>
      <v-card height=500>
           <v-row
          align="center"
          justify="center"
        ><v-col
          align="center"
          justify="center"
        >
        <v-btn width="125" height="450" to="/income" color="success" dark outlined>Income </v-btn>
        <br>
        </v-col>
        </v-row>
      </v-card>
    </v-flex>

    <v-flex xs12 md4>
      <v-card height=500>
           <v-row
          align="center"
          justify="center"
        ><v-col
          align="center"
          justify="center"
        >
        <v-btn width="125" height="450" to="/expense"  color="red" dark outlined>Expense </v-btn>
        <br>
        </v-col>
        </v-row>
      </v-card>
    </v-flex>

    <v-footer app>
      <span>&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
</v-layout>
   </v-container>
  </v-app>
</template>

<script>
  export default {
    data () {
      return {
        tabs: null,
        }
    },
  }
</script>
<script>
export default {
  name: 'Profile',
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  // mounted() {
  //   if (!this.currentUser) {
  //     this.$router.push('/login');
  //   }
  // }
};
</script>
<script>
  export default {
    data () {
      return {
        show: false,
      }
    },
  }
</script>