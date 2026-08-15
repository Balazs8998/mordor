import { Routes } from '@angular/router';

export const routes: Routes = [

  {
    path: '',
    loadComponent: () =>
      import('./orc/page/orc-list/component/orc-list/orc-list').then(m => m.OrcList)
  },
  {
    path: 'orcs/create',
    loadComponent: () =>
      import('./orc/page/orc-create/components/orc-create/orc-create').then(m => m.OrcCreate)
  },
  {
    path: 'orcs',
    loadComponent: () =>
      import('./orc/page/orc-list/component/orc-list/orc-list').then(m => m.OrcList)
  },
  {
    path: 'hordes/create',
    loadComponent: () =>
      import('./great-hall/horde/page/horde-create/component/horde-create').then(m => m.HordeCreate)
  },
  {
    path:'**',
    loadComponent:() => import(
      './core/components/notfound/notfound').then(c => c.Notfound)
  }

];
