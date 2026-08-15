import {Routes} from '@angular/router';

export const routes: Routes = [

  {
    path: '',
    loadComponent: () =>
      import('./mustering-grounds/pages/mustering-grounds/mustering-grounds').then(m => m.MusteringGrounds)

  },

  {
    path: 'mustering-grounds',
    loadComponent: () =>
      import('./mustering-grounds/pages/mustering-grounds/mustering-grounds').then(m => m.MusteringGrounds)
  },

  {
    path: 'great-hall',
    loadComponent: () =>
      import('./great-hall/pages/great-hall/great-hall').then(m => m.GreatHall)
  },

  {
    path: 'war-hall',
    loadComponent: () =>
      import('./war-hall/pages/war-hall/war-hall').then(m => m.WarHall)
  },

  {
    path: 'war-table',
    loadComponent: () =>
      import('./war-table/pages/war-table/war-table').then(m => m.WarTable)
  },

  {
    path: '**',
    loadComponent: () => import(
      './core/components/notfound/notfound').then(c => c.Notfound)
  }

];
