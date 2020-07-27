
<template>
<v-app class="theme--light">
<v-container >
  <v-app class="theme--light">
  <v-card >
    <v-toolbar flat color="cyan" class="theme--dark">

      <v-toolbar-title class="text-center">User Profile</v-toolbar-title>

      <v-spacer></v-spacer>
    
      <v-btn to="/login" class="mr-3" text medium color="white"> 
      <span>sign-out </span>
      <v-icon color="white">mdi-exit-to-app</v-icon>
      </v-btn>

      
    </v-toolbar>

       
        <v-card flat>
        </v-card>
  </v-card>
  </v-app>
  <v-btn fab depressed x-large dark color="purple">
       <v-icon>mdi-account-plus</v-icon>
  </v-btn> 
</v-container>

</v-app>
</template>

<script>
  export default {
    data () {
      return {
        tabs: null,
        text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',
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